import java.io.IOException;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create();
        server.bind(null, 8080);
        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "<html><head><link rel=\"stylesheet\" href=\"style.css\"></head><body>"
                    + "<div id=\"app\"><h1>To-Do List</h1><ul id=\"taskList\"></ul>"
                    + "<input type=\"text\" id=\"newTaskInput\" placeholder=\"Enter a new task\">"
                    + "<button onclick=\"addTask()\">Add Task</button></div>"
                    + "<script src=\"app.js\"></script></body></html>";

            t.sendResponseHeaders(200, response.length());
            var os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
