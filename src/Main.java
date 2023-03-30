public class Main {
    public static void main(String[] args) {
        System.out.println("All data about holidays are from "+APIConnector.url);
        Holiday holiday = APIConnector.getHoliday(APIConnector.getDataStringFromApi(),StateCode.BADEN_WÜRTTEMBERG,2023,HolidayName.WEIHNACHTSFERIEN);
        System.out.println(holiday.getStart());
    }
}