/**
 * Copyright (C) 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import conf.AuthFilter;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import helpers.ConfigUtil;
import net.sf.ehcache.config.generator.ConfigurationUtil;
import ninja.Result;
import ninja.Results;
import ninja.Router;
import ninja.session.Session;

import com.google.inject.Singleton;

import models.Contact;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class ApplicationController {

    public Result index() {

        HashMap<String, Object> m = new HashMap<>();
        m.put("data", "mydata");
        m.put("name", "benny");

        return Results.html().render("var", m);
    }

    public Result contact() {
        Contact o = new Contact();
        o.setName("jenny");
        o.setTel("0128899");

        return Results.json().render(o);
    }

    public Result data() {
        HashMap<String, Object> m = new HashMap<>();
        m.put("success", 1);
        m.put("data", new int[] { 1, 2, 3, 4 });

        return Results.json().render(m);
    }

    public Result login(Session se) {
        se.put(AuthFilter.USERNAME, "ben");
        return Results.text().render("done login");
    }

    public Result logout(Session se) {
        se.clear();
        return Results.text().render("done logout");
    }

    public Result main(Session se) {
        String b = se.get("username");
        return Results.text().render(b);
    }

    public Result sample() throws Exception {
        Configuration cfg = ConfigUtil.getConfiguration();
        Map<String, Object> map = new HashMap<>();
        map.put("var", "xxx");
        Template tpl = cfg.getTemplate("sample.ftl.html");
        Writer w = new StringWriter();
        tpl.process(map, w);

        String s = w.toString();
        w.close();

        return Results.text().render(s);
    }
    
    public Result helloWorldJson() {
        
        SimplePojo simplePojo = new SimplePojo();
        simplePojo.content = "Hello World! Hello Json!";

        return Results.json().render(simplePojo);
    }
    
    public static class SimplePojo {

        public String content;
        
    }
}
