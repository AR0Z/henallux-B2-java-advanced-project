package Model;

import java.text.SimpleDateFormat;

public class Filter {
    private Category category;
    private Supplier supplier;
    private String startDate;
    private String endDate;
    private int order;

    // create constructor where each parameter is optional
    public Filter(Category category, Supplier supplier, String startDate, String endDate, int order) {
        this.category = category;
        this.supplier = supplier;
        this.startDate = startDate;
        this.endDate = endDate;
        this.order = order;
    }

    public Category getCategory() {
        return category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFormatedDate(String date) {
        SimpleDateFormat inSDF = new SimpleDateFormat("dd/mm/yyyy");
        SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");
        String outDate = "";
        try {
            outDate = outSDF.format(inSDF.parse(date));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getOrder() {
        return order;
    }
}
