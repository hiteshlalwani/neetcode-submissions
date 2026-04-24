class TimeMap {

    Map<String, TreeMap<Integer, String>> lookupMap;

    public TimeMap() {
        lookupMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        lookupMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!lookupMap.containsKey(key)) return "";
        return Optional.ofNullable(lookupMap.get(key)).map(data -> data.floorEntry(timestamp)).map(entry -> entry.getValue()).orElse("");
    }
}
