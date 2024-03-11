// Implements a set of objects using a hash table.
// The hash table uses separate chaining to resolve collisions.
// Original from buildingjavaprograms.com supplements
// minor edits by Bill Iverson, Bellevue College, January 2022

public class HashSet<E> {
    private static final double MAX_LOAD_FACTOR = 0.75;
    private HashEntry<E>[] elementData;
    private int size;

    // Constructs an empty set.
    @SuppressWarnings("unchecked")
    public HashSet() {
        elementData = new HashEntry[10];
        size = 0;
    }

    // ADD METHODS HERE for exercise solutions:

    public boolean containsAll(HashSet<E> other) {
        if (size() == other.size())
            return equalsIgnoringSize(other);
        if (size() == 0)
            return false;
        else {
            for (HashEntry<E> front : other.elementData) {
                HashEntry<E> current = front;
                while (current != null) {
                    if (!contains(current.data)) {
                        return false;
                    }
                    current = current.next;
                }
            }
        }
        return true;
    }

    public boolean equals(HashSet<E> o) {
        return equalsIgnoringSize(o);
    }

    public boolean equalsIgnoringSize(Object o) {
        if (o instanceof HashSet) {
            @SuppressWarnings("unchecked")
            HashSet<E> other = (HashSet<E>) o;
            for (HashEntry<E> front : elementData) {
                HashEntry<E> current = front;
                while (current != null) {
                    if (!other.contains(current.data)) {
                        return false;
                    }
                    current = current.next;
                }
            }
            for (HashEntry<E> front : other.elementData) {
                HashEntry<E> current = front;
                while (current != null) {
                    if (!this.contains(current.data)) {
                        return false;
                    }
                    current = current.next;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void removeAll(HashSet<E> other) {
        for (HashEntry<E> front : elementData) {
            HashEntry<E> current = front;
            while (current != null) {
                if (other.contains(current.data)) {
                    remove(current.data);
                }
                current = current.next;
            }
        }
    }

    public void retainAll(HashSet<E> other) {
        for (HashEntry<E> front : elementData) {
            HashEntry<E> current = front;
            while (current != null) {
                if (!other.contains(current.data)) {
                    remove(current.data);
                }
                current = current.next;
            }
        }
    }

    // Adds the given element to this set, if it was not already
    // contained in the set.
    public void add(E value) {
        if (!contains(value)) {
            if (loadFactor() >= MAX_LOAD_FACTOR) {
                rehash();
            }

            // insert new value at front of list
            int bucket = hashFunction(value);
            elementData[bucket] = new HashEntry<E>(value, elementData[bucket]);
            size++;
        }
    }

    // Removes all elements from the set.
    public void clear() {
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    // Returns true if the given value is found in this set.
    public boolean contains(E value) {
        int bucket = hashFunction(value);
        HashEntry<E> current = elementData[bucket];
        while (current != null) {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Returns true if there are no elements.
    public boolean isEmpty() {
        return size == 0;
    }

    // Removes the given value if it is contained in the set.
    // If the set does not contain the value, has no effect.
    public void remove(E value) {
        int bucket = hashFunction(value);
        if (elementData[bucket] != null) {
            // check front of list
            if (elementData[bucket].data.equals(value)) {
                elementData[bucket] = elementData[bucket].next;
                size--;
            } else {
                // check rest of list
                HashEntry<E> current = elementData[bucket];
                while (current.next != null && !current.next.data.equals(value)) {
                    current = current.next;
                }

                // if the element is found, remove it
                if (current.next != null && current.next.data.equals(value)) {
                    current.next = current.next.next;
                    size--;
                }
            }
        }
    }

    // Returns the number of elements.
    public int size() {
        return size;
    }

    // Returns a string representation such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        boolean first = true;
        if (!isEmpty()) {
            for (int i = 0; i < elementData.length; i++) {
                HashEntry<E> current = elementData[i];
                while (current != null) {
                    if (!first) {
                        result += ", ";
                    }
                    result += current.data;
                    first = false;
                    current = current.next;
                }
            }
        }
        return result + "]";
    }

    // Returns the preferred hash bucket index for the given value.
    private int hashFunction(E value) {
        return Math.abs(value.hashCode()) % elementData.length;
    }

    private double loadFactor() {
        return (double) size / elementData.length;
    }

    // Resizes the hash table to twice its former size.
    @SuppressWarnings("unchecked")
    private void rehash() {
        // replace element data array with a larger empty version
        HashEntry<E>[] oldElementData = elementData;
        elementData = new HashEntry[2 * oldElementData.length];
        size = 0;

        // re-add all of the old data into the new array
        for (int i = 0; i < oldElementData.length; i++) {
            HashEntry<E> current = oldElementData[i];
            while (current != null) {
                add((E) current.data);
                current = current.next;
            }
        }
    }

    // Represents a single value in a chain stored in one hash bucket.
    @SuppressWarnings("hiding")
    private class HashEntry<E> {
        public E data;
        public HashEntry<E> next;

        @SuppressWarnings("unused")
        public HashEntry(E data) {
            this(data, null);
        }

        public HashEntry(E data, HashEntry<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}
