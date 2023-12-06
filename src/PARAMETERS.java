import java.time.LocalDate;
import java.util.Random;

public class PARAMETERS {

	String[] Website = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };
	Random rand = new Random();
	int RandomIndexWebsite = rand.nextInt(2);

	String[] ArabicPlaces = { "جدة", "دبي" };
	String[] EnglishPlaces = { "Dubai", "jeddah", "Riyadh" };
	int RandomIndexArabicPlaces = rand.nextInt(2);
	int RandomIndexEnglishPlaces = rand.nextInt(3);

	LocalDate CurrentDate = LocalDate.now();
	int day = CurrentDate.getDayOfMonth();
	int ExpectedDepatureFlightDate = day + 1;
	int ExpectedReturnFlightDate = day + 2;
}
