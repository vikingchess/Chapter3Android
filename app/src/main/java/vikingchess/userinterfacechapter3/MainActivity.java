package vikingchess.userinterfacechapter3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.graphics.Color.BLUE;

public class MainActivity extends AppCompatActivity {
    // auto complete list data
    String[] continents = {"North America", "South America", "Europe", "Asia", "Africa", "Antarctica"};
    // Declare animal variable
    EditText favoriteAnimal;
    TextView answerText;
    TextView continentAnswer;
    TextView habitatAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Auto complete list
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, continents);
        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.continent);
        actv.setThreshold(1);
        actv.setAdapter(adapter);
        actv.setTextColor(BLUE);

        // Create Mutlt auto complate list
        MultiAutoCompleteTextView habitat = (MultiAutoCompleteTextView)this.findViewById(R.id.habitat);
        ArrayAdapter<String> aa2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, new String[]
                {
                        "Ocean", "Lake", "Desert", "Rainforest", "Tundra", "Forest", "Mountains", "Wetlands", "Plains"
                });
        habitat.setAdapter(aa2);
        habitat.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


        // Adding function to the button
        Button continentButton = (Button) this.findViewById(R.id.continentButton);
        continentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO This function needs refractoring
                //TODO put away keyboard
                // Grab animal name
                favoriteAnimal = (EditText) findViewById(R.id.favoriteAnimalText);
                String FavoriteAnimalString=favoriteAnimal.getText().toString();
                answerText = (TextView) findViewById(R.id.answerTextView);
                // Grab Continent name

                continentAnswer = (TextView) findViewById(R.id.continent);
                String continenetAnswerText=continentAnswer.getText().toString();
                // Grab habitat
                habitatAnswer = (TextView) findViewById(R.id.habitat);
                String habitatAnswerText = habitatAnswer.getText().toString();
                //Display answer
                answerText.setText("Your Favorite animal is a " + FavoriteAnimalString + " it resides on the " + continenetAnswerText
                 + " continent in a " + habitatAnswerText + "habitat.");

                //TODO Open new map view display continent
                    //seperate function?
            }
        });
    }
}
