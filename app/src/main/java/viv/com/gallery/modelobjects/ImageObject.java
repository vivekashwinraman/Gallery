package viv.com.gallery.modelobjects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vraman on 6/15/17.
 */

public class ImageObject implements Parcelable {
    private String rootPath;
    private String imageUri;
    private String title;

    public ImageObject() {

    }

    public ImageObject(String rootPath, String imageUri, String title) {
        this.rootPath = rootPath;
        this.imageUri = imageUri;
        this.title = title;
    }

    public String getImageUri() {
        return imageUri;
    }

    public String getRootPath() {
        return rootPath;
    }

    public String getTitle() {
        return title;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(imageUri);
        parcel.writeString(imageUri);
        parcel.writeString(title);
    }

    public static final Parcelable.Creator<ImageObject> CREATOR = new Creator<ImageObject>() {
        public ImageObject createFromParcel(Parcel source) {
            ImageObject imageObject = new ImageObject();
            imageObject.rootPath = source.readString();
            imageObject.imageUri = source.readString();
            imageObject.title = source.readString();
            return imageObject;
        }

        public ImageObject[] newArray(int size) {
            return new ImageObject[size];
        }
    };
}