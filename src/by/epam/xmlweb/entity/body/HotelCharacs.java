package by.epam.xmlweb.entity.body;

/**
 * Created by Диана и Глеб on 31.05.2016.
 */
public class HotelCharacs {
    private int stars;
    private boolean meal;
    private String kindOfMeal;
    private int rooms;
    private boolean condition;
    private boolean tv;
    private boolean wifi;

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public boolean isMeal() {
        return meal;
    }

    public void setMeal(boolean meal) {
        this.meal = meal;
    }

    public String getKindOfMeal() {
        return kindOfMeal;
    }

    public void setKindOfMeal(String kindOfMeal) {
        this.kindOfMeal = kindOfMeal;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    @Override
    public String toString() {
        return
                "\n   Stars: " + stars +
                ", \n   Meal: " + meal +
                ", \n   Kind of Meal: " + kindOfMeal +
                ", \n   Rooms: " + rooms +
                ", \n   Condition: " + condition +
                ", \n   TV: " + tv +
                ", \n   WIFI: " + wifi;
    }
}
