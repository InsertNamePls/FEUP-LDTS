public class StringReplacer implements StringTransformer{
    private char old,news;
    StringReplacer(char oldchar ,char newchar){
        old = oldchar;
        news = newchar;
    }
    public void execute(StringDrink drink){
        drink.setText(drink.getText().replace(old,news));
    }
}
