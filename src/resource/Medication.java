package resource;

/**
 * Created by Anar on 7/23/15.
 */
public class Medication {
    public static final String ROOT = "/ClinicalDocument/component/structuredBody/component/section/entry/supply/product";
    public static final String NAME = "./manufacturedProduct/manufacturedMaterial/name";
    public static final String CODE = "./manufacturedProduct/manufacturedMaterial/code/@code";
    public static final String FORM = "./manufacturedProduct/manufacturedMaterial/formCode/@code";
    public static final String AMOUNT = "./manufacturedProduct/manufacturedMaterial/asContent/containerPackagedMedicine/capacityQuantity/@value";

    private String name;
    private long code;
    private String manufacturer;
    private String kind;
    private Product product;

    public Medication(String name, long code, Product product) {
        this.name = name;
        this.code = code;
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public long getCode() {
        return code;
    }

    public static class Product {
        private String amount;
        private String form;
        private String ingridient;
        private String item;

        public Product(String form, String amount) {
            this.form = form;
            this.amount = amount;
        }
    }

    public static class Package {
        private String content;
        private String container;
        private String item;
        private String amount;
    }
}

