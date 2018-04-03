package conf;

import controllers.MailController;
import ninja.Router;
import controllers.ApplicationController;

public class ApplicationRoutes {

    public static void init(Router router) {
        router.GET().route(prefix("contact")).with(ApplicationController::contact);
        router.GET().route(prefix("login")).with(ApplicationController::login);
        router.GET().route(prefix("logout")).with(ApplicationController::logout);
        router.GET().route(prefix("main")).with(ApplicationController::main);
        router.GET().route(prefix("data")).with(ApplicationController::data);
        router.GET().route(prefix("sample")).with(ApplicationController::sample);
        router.GET().route(prefix("hello_world.json")).with(ApplicationController::helloWorldJson);
    }

    static String prefix(String url) {
        return String.format("/home/%s", url);
    }
}
