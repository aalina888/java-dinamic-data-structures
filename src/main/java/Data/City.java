package Data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = CityDeserializer.class)
public class City implements Comparable<City> {
    private String name;
    private String country;
    private String postalCode;
    private double longitude;
    private double latitude;
    private int indexInArray;
    private int left = -1;
    private int right = -1;

    public City(String name, String country, String postalCode, double longitude, double latitude) {
        setName(name);
        setCountry(country);
        setPostalCode(postalCode);
        setLongitude(longitude);
        setLatitude(latitude);
    }

    public City(City city) {
        this(city.getName(), city.getCountry(), city.getPostalCode(), city.getLongitude(), city.getLatitude());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLeft(int index) {
        this.left = index;
    }

    public void setRight(int index) {
        this.right = index;
    }

    public void setIndexInArray(int indexInArray) {
        this.indexInArray = indexInArray;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public int getIndexInArray() {
        return indexInArray;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    @Override
    public int compareTo(City city) {
        return getName().compareTo(city.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof City) {
            City city = (City) obj;

            if (getName().equals(city.getName())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("City: %s\tCountry: %s\tPostal code: %s\tLongitude: %.2f\tLatitude: %.2f\n", getName(), getCountry(), getPostalCode(), getLongitude(), getLatitude());
    }
}
