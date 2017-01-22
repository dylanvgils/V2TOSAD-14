package businessLogic.generate;

/**
 * Created by Dion on 1/22/2017.
 */
public class GenerateFactory {
    public Generate getGenerate(String generateType){
        if(generateType == null){
            return null;
        }
        if(generateType.equalsIgnoreCase("ARNG")){
            return new AttributeRangeGenerate();
        }

        return null;
    }
}
