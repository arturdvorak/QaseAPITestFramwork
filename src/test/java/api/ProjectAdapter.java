package api;

import models.Project;

public class ProjectAdapter extends BaseAdapter {
    String uriAdd = "project";

    public String addProject(Project project) {
        return
                post(uriAdd, gson.toJson(project), 200)
                        .body().path("code");
    }
}
