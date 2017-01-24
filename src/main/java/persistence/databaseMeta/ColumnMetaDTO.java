package persistence.databaseMeta;

public class ColumnMetaDTO {
    private String name;
    private String dataType;
    private int dataLength;
    private int dataPrecision;
    private int dataScale;

    public ColumnMetaDTO(String name, String dataType, int dataLength, int dataPrecision, int dataScale) {
        this.name = name;
        this.dataType = dataType;
        this.dataLength = dataLength;
        this.dataPrecision = dataPrecision;
        this.dataScale = dataScale;
    }

    public String getName() {
        return name;
    }

    public String getDataType() {
        return dataType;
    }

    public int getDataLength() {
        return dataLength;
    }

    public int getDataPrecision() {
        return dataPrecision;
    }

    public int getDataScale() {
        return dataScale;
    }
}
