import java.util.List;

public class StringTransformerGroup implements StringTransformer{
    List<StringTransformer> rollOut;

    public StringTransformerGroup(List<StringTransformer> OptimusPrime) {
        rollOut = OptimusPrime;
    }

    @Override
    public void execute(StringDrink drink) {
        for (int i = 0; i < rollOut.size();i++)rollOut.get(i).execute(drink);
    }
}
