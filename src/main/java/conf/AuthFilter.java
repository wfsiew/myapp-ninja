package conf;

import ninja.*;

public class AuthFilter implements Filter {

    public static final String USERNAME = "username";

    @Override
    public Result filter(FilterChain filterChain, Context context) {
        if (context.getSession() == null ||
                context.getSession().get(USERNAME) == null) {
            return Results.forbidden().html().template("/views/system/403forbidden.ftl.html");
        } else {
            return filterChain.next(context);
        }
    }
}
