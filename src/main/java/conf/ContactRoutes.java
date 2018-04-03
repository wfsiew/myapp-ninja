package conf;

import controllers.ContactController;
import ninja.Router;

public class ContactRoutes {

    public static void init(Router router) {
        router.GET().route(prefix("data")).with(ContactController::data);
    }

    static String prefix(String url) {
        return String.format("/contact/%s", url);
    }
}
