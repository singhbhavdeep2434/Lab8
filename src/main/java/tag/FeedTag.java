package tag;

import java.io.IOException;
import java.util.List;

import Model.Feed;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.TagSupport;


public class FeedTag extends TagSupport {
    private static final long serialVersionUID = 1L;
	private List<Feed> feeds;

    public void setFeeds(List<Feed> feeds) {
        this.feeds = feeds;
    }

    @Override
    public int doStartTag() throws JspException {
        if (feeds != null) {
            for (Feed feed : feeds) {
                try {
                    pageContext.getOut().write("<h2>" + feed.getTitle() + "</h2>");
                    pageContext.getOut().write("<p>" + feed.getDescription() + "</p>");
                    pageContext.getOut().write("<small>" + feed.getDate() + "</small>");
                    pageContext.getOut().write("<hr />");
                } catch (IOException e) {
                    throw new JspException("Error in FeedTag", e);
                }
            }
        }
        return SKIP_BODY; 
    }
}
