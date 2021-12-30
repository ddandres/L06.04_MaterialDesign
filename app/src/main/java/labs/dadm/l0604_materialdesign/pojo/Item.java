/*
 * Copyright (c) 2016. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0604_materialdesign.pojo;

// Custom POJO representing the data to be displayed on the RecyclerView.
public class Item {

    private String text;
    private int image;
    private boolean checked;

    public Item(String text, int image) {
        this.text = text;
        this.image = image;
        this.checked = false;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }


}
