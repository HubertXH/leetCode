package entity;

public class MountainArray {

    private int[] data;


    public int get(int index) {
        if (index < 0 || index > data.length - 1) {
            return -1;
        }
        return data[index];
    }


    public int length() {
        return data.length;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }
}
