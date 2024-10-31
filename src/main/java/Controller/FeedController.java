package Controller;
import java.io.IOException;
import java.util.List;

import Model.Feed;
import Model.FeedParser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/feedsCustom", "/feedsJSTL"})
public class FeedController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FeedParser feedParser = new FeedParser();
        List<Feed> feeds = feedParser.parseFeeds(getServletContext().getRealPath("/WEB-INF/feeds.json"));
        
        request.setAttribute("feeds", feeds);

        // Check the URL to decide which JSP to forward to
        String path = request.getServletPath();
        if ("/feedsCustom".equals(path)) {
            request.getRequestDispatcher("/View/feedListCustomTag.jsp").forward(request, response);
        } else if ("/feedsJSTL".equals(path)) {
            request.getRequestDispatcher("/View/feedListJSTL.jsp").forward(request, response);
        }
    }
}
