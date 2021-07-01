import javax.servlet.*;
import javax.servlet.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request1 = (HttpServletRequest) request;
        if (request1.getSession().getAttribute("login") != null){
            chain.doFilter(request, response);
        }else
        {
            request.getRequestDispatcher("/views/login.jsp").forward(request,response);
        }
    }
}
