package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Category{
    private final Integer id;
    private final List<Integer> parentId; // parent_idx
    private final List<Integer> childrenId; // children_id
    private final String name;

    public Category(Integer id, List<Integer> parentId, List<Integer> childrenId, String name) {
        this.id = id;
        this.parentId = Objects.requireNonNullElseGet(parentId, ArrayList::new);
        this.childrenId = Objects.requireNonNullElseGet(childrenId, ArrayList::new);
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public List<Integer> getParentId() {
        return parentId;
    }

    public List<Integer> getChildrenId() {
        return childrenId;
    }

    public String getName() {
        return name;
    }

    public void updateChildrenId(Integer childId) {
        this.childrenId.add(childId);
    }

    public void updateParentIdx(Integer parentId) {
        this.parentId.add(parentId);
    }

    public String toJson() {
        return String.format("{\"category_id\":%d,\"parent_idx\":%s,\"children_id\":%s,\"name\":\"%s\"}",
                this.id,
                this.parentId.toString(),
                this.childrenId.toString(),
                this.name);
    }

}
