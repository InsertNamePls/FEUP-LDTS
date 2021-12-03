public class StringInverter implements StringTransformer{
    public void execute(StringDrink drink){
        StringBuilder str = new StringBuilder(drink.getText());
        drink.setText(str.reverse().toString());
    }
}
