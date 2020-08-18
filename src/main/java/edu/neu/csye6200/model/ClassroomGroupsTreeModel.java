package edu.neu.csye6200.model;

import edu.neu.csye6200.manager.DatabaseManager;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Data model for {@link javax.swing.JTree JTree} and {@link Classroom Classroom}
 * @author Haotian Zheng
 */
public class ClassroomGroupsTreeModel implements TreeModel {

    private Integer classRoomID;
    private Map<RatioRule, List<ClassroomGroup>> groupMap;
    public ClassroomGroupsTreeModel(Integer classRoomID) {
        this.classRoomID = classRoomID;
        refresh();
    }

    public void refresh()
    {
        List<ClassroomGroup> groupList = DatabaseManager.getDB().onDemand(ClassroomDao.class).find(Classroom.class, classRoomID).getGroups();
//        groupMap = groupList.stream()
    }

    @Override
    public Object getRoot() {
        return null;
    }

    @Override
    public Object getChild(Object parent, int index) {
        return null;
    }

    @Override
    public int getChildCount(Object parent) {
        return 0;
    }

    @Override
    public boolean isLeaf(Object node) {
        return false;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {

    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        return 0;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {

    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {

    }
}
