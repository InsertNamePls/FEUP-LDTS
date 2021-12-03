public class StringCaseChanger implements StringTransformer{
    public void execute(StringDrink drink){
        char[] drinky = drink.getText().toCharArray();
        for (int i = 0; i < drinky.length; i++) {
            if(Character.isLowerCase(drinky[i])) {
                drinky[i] = Character.toUpperCase(drinky[i]);
            }else {
                drinky[i] = Character.toLowerCase(drinky[i]);
            }
        }
        drink.setText(String.valueOf(drinky));
    }
}

