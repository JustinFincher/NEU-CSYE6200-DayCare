package edu.neu.csye6200.model;

import edu.neu.csye6200.helper.annotation.JavaBeansIgnore;
import edu.neu.csye6200.manager.DatabaseManager;

import java.util.*;
import java.util.stream.Collectors;

public class Classroom extends DBObject
{
    @JavaBeansIgnore
    public List<ClassroomGroup> getGroups()
    {
        if (getGroupIds().isEmpty()) return new ArrayList<>();
        return Arrays.stream(getGroupIds().split(","))
                .map(Integer::parseInt)
                .map(i -> DatabaseManager.getDB()
                        .onDemand(ClassroomGroupDao.class)
                        .find(ClassroomGroup.class, i))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
    @JavaBeansIgnore
    public void setGroups(List<ClassroomGroup> groups)
    {
        groupIds = groups.stream().map(DBObject::getId).map(Object::toString).collect(Collectors.joining(","));
    }
    public String getGroupIds() { return groupIds == null ? "" : groupIds; }
    public void setGroupIds(String groupIds) { this.groupIds = groupIds; }
    private String groupIds;

    public String getRoomNumber() { return roomNumber == null ? "" : roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    private String roomNumber;

    @Override
    public void saveCsv(Map<String, String> map) {
        super.saveCsv(map);
        map.put("room_number", getRoomNumber());
    }

    @Override
    public void loadCsv(Map<String, String> map) {
        super.loadCsv(map);
        setRoomNumber(map.getOrDefault("room_number",""));
    }
}
