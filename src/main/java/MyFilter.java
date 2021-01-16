import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class MyFilter extends HttpServlet implements Filter {

    private FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) {
        try {
            request.setCharacterEncoding("UTF-8");
            filterChain.doFilter(request, response);
        }
        catch(ServletException sx) {
            filterConfig.getServletContext().log(sx.getMessage());
        }
        catch(IOException iox) {
            filterConfig.getServletContext().log(iox.getMessage());
        }
    }

}