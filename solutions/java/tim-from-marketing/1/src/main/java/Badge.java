class Badge {
    public String print(Integer id, String name, String department) {
        String first = id != null ? "[" + id + "] - " : "";
        String last = department != null ? department.toUpperCase() : "OWNER";
        return first + name + " - " + last;
    }
}
