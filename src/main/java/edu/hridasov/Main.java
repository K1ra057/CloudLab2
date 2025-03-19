package edu.hridasov;

/*
@autrhor Дима
@project Default (Template) Project
@class ${NAME}
@version 1.0.0
@sinc 20.03.2025 - 00 - 08



*///TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().print("Hello from Java!\n");
    }

    public static void main(String[] args) throws Exception {
        String portStr = System.getenv("PORT");
        System.out.println("PORT value: " + portStr); // Отладочный вывод

        int port = (portStr != null) ? Integer.parseInt(portStr) : 8080; // Значение по умолчанию
        Server server = new Server(port);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new Main()), "/*");
        server.start();
        server.join();

    }

}
