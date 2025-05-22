class MyHashMap {
    private static final int SIZE = 10000;
    private List<Node>[] map;

    private class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        map = new LinkedList[SIZE];
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (map[index] == null) {
            map[index] = new LinkedList<>();
        }
        for (Node node : map[index]) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        map[index].add(new Node(key, value));
    }

    public int get(int key) {
        int index = hash(key);
        if (map[index] != null) {
            for (Node node : map[index]) {
                if (node.key == key) {
                    return node.value;
                }
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        if (map[index] != null) {
            for (Iterator<Node> it = map[index].iterator(); it.hasNext();) {
                Node node = it.next();
                if (node.key == key) {
                    it.remove();
                    return;
                }
            }
        }
    }

    private int hash(int key) {
        return Integer.hashCode(key) % SIZE;
    }
}
