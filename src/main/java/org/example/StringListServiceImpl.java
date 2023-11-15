package org.example;

import java.util.Arrays;

public class StringListServiceImpl implements StringList {
    private String[] arrayString;
    private int size = 5;

    public StringListServiceImpl() {
        this.arrayString = new String[size];
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new NullPointerException("Укажите значение");
        }
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i] == null) {
                arrayString[i] = item;
                return arrayString[i];
            }
        }
        throw new ArrayIndexOutOfBoundsException("Массив заполнен");
    }

    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new NullPointerException("Укажите значение");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Ты крокодил");
        }
        if (index < arrayString.length) {
            if (arrayString[index] == null) {
                arrayString[index] = item;
                return arrayString[index];
            } else {
                String[] arrayString2 = new String[size + 1];
                System.arraycopy(arrayString, 0, arrayString2, 0, index);
                arrayString2[index] = item;
                System.arraycopy(arrayString, index, arrayString2, index + 1, arrayString.length - index);
                arrayString = arrayString2;
            }
            return item;
        } else {
            throw new ArrayIndexOutOfBoundsException("Значение индекса больше размера массива");
        }
    }

    @Override
    public String set(int index, String item) {
        if (item == null) {
            throw new NullPointerException("Укажите значение");
        }
        if (index <= arrayString.length - 1) {
            arrayString[index] = item;
            return arrayString[index];
        }
        throw new ArrayIndexOutOfBoundsException("Значение индекса больше размера массива");
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new NullPointerException("Укажите значение");
        }
        int index = indexOf(item);
        System.arraycopy(arrayString, index + 1, arrayString, index, size - 1);
        return item;
    }

    @Override
    public String remove(int index) {
//        if (index <= arrayString.length) {
//            if (arrayString[index] != null) {
//                return arrayString[index] = null;
//            }
//            throw new RuntimeException("В массиве по данному индексу нет элементов");
//        } else {
//            throw new ArrayIndexOutOfBoundsException("Такого индекса в массиве нет");
//        }
        if (index < 0) {
            throw new IllegalArgumentException("Ты крокодил");
        }
        if (arrayString[index] == null) {
            throw new IllegalArgumentException("Нет такого элемента");
        }
        String item = arrayString[index];
        System.arraycopy(arrayString, index + 1, arrayString, index, size - 1);
        return item;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new NullPointerException("Укажите значение");
        }
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i] != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            throw new NullPointerException("Укажите значение");
        }
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i] == item) {
                return 1;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new NullPointerException("Укажите значение");
        }
        for (int i = arrayString.length - 1; i >= 0; i--) {
            if (arrayString[i] == item) {
                return 1;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index <= arrayString.length - 1) {
            return arrayString[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Такого индекса в массиве нет");
        }
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(otherList.toArray(), arrayString);
    }

    @Override
    public int size() {
        return arrayString.length;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i] != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < arrayString.length; i++) {
            arrayString[i] = null;
        }
    }

    @Override
    public String[] toArray() {
        String[] newArray = new String[size];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = arrayString[i];
        }
        return newArray;
    }
}
