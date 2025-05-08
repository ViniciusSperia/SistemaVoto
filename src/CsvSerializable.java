public interface CsvSerializable {
    String toCsvRow(String separator);
    static String csvHeader(String separator) {
        return "Name" + separator + "Number" + separator + "Party" + separator + "Votes";
    }
}
