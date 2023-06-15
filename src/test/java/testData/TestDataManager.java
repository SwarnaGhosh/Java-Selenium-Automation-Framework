package testData;

import org.testng.annotations.DataProvider;

import java.util.*;

/**
 *
 * This  class Helps to handle and generate Testdata.
 *
 * @author swarnaprabha Ghosh
 */

public class TestDataManager {

     public static List<String> dropdownTeamsName = new ArrayList<>();
     public static HashMap<String,String> teamsWithPageTitle =new LinkedHashMap<>();


    public static HashMap<String,String> getTeamsWithPageTitleMp() {
        teamsWithPageTitle.put("Atlanta","Hawks - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("Boston","Celtics - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("Brooklyn","Brooklyn Nets | The Official Site of the Brooklyn Nets");
        teamsWithPageTitle.put("Charlotte","Hornets - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("Chicago","Bulls - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("Cleveland","Cavaliers - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("Dallas","Home - The Official Home of the Dallas Mavericks");
        teamsWithPageTitle.put("Denver","Nuggets - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("Detroit","Pistons - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("Golden State","Home | Golden State Warriors");
        teamsWithPageTitle.put("Houston","Rockets - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("Indiana","Pacers - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.comA");
        teamsWithPageTitle.put("LA Clippers","Pacers - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("LA Lakers","Lakers - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("Memphis","Grizzlies - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("Miami","Miami HEAT Team Homepage - Miami HEAT");
        teamsWithPageTitle.put("Milwaukee","Bucks - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("Minnesota","Timberwolves - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("New Orleans","Pelicans - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("New York","Knicks - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("Oklahoma City","Thunder- The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("Orlando","Magic - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("Philadelphia","Sixers - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("Phoenix","Suns.com");
        teamsWithPageTitle.put("Portland","Trail Blazers - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com");
        teamsWithPageTitle.put("Sacramento","Kings - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com\"");
        teamsWithPageTitle.put("San Antonio","Spurs - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com\"");
        teamsWithPageTitle.put("Toronto","Raptors - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com\"");
        teamsWithPageTitle.put("Utah","Jazz - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com\"");
        teamsWithPageTitle.put("Washington","Wizard - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com\"");



        return teamsWithPageTitle;
    }

    public static List<String> getDropdownTeamsName() {
        HashMap<String,String> map1 = getTeamsWithPageTitleMp();
        for (Map.Entry<String,String> entry: map1.entrySet()){
            dropdownTeamsName.add(entry.getKey());
        }

        return dropdownTeamsName;
    }

    @DataProvider(name = "test-data")
    public Object[][] dataProviderMethod(){
        return new Object[][]{
                {"Atlanta","Hawks - The official site of the NBA for the latest NBA Scores, Stats & News. | NBA.com"},

        };
    }
}
