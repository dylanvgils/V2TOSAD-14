package businessLogic.generate;

/**
 * Created by Dion on 1/22/2017.
 */
public class GenerateFactory {
    public Generate getGenerate(String generateType){
        if(generateType == null){
            return null;
        }
        System.out.println(generateType);
        if(generateType.equalsIgnoreCase("ARNG")){
            return new AttributeRangeGenerate();
        }else if(generateType.equalsIgnoreCase("ACMP")) {
            return new AttributeCompareGenerate();
        }else if(generateType.equalsIgnoreCase("ALIS")){
            return new AttributeListGenerate();
        }else if(generateType.equalsIgnoreCase("TCMP")){
            return new TupleCompareGenerate();
        }else if(generateType.equalsIgnoreCase("ICMP")){
            return new InterEntityCompareGenerate();
        }

        return null;
    }
}
