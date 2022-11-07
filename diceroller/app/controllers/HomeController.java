package controllers;

import play.mvc.*;
import play.twirl.api.Html;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render());
    }

    public Result applyHtml() {
        return ok(Html.apply("<h1>This text will appear as a heading 1</h1>"));
    }

    public Result version() {
        return ok("{\"appname\":\"diceroller\",\"version\":\"v0.1.0\"}");
    }
    public Result roll() {
        int newRoll = ThreadLocalRandom.current().nextInt(1,7);

        String jsonTemplate = "{\"value\":%s}";

        String jsonResult = String.format(jsonTemplate, newRoll);

        return ok(jsonResult);
    }

}