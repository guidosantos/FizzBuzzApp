package fizzbuzz;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/FizzBuzz")
public class FizzBuzzController {

	@GET
	@Path("/{param}")
	public Response fizzbuzz(@PathParam("param") String numbers) {

		String response = "";

		/* if no numbers are passed as argument */
		if (numbers == null || numbers.isEmpty()) {
			return Response.status(200).entity("No numbers passed.").build();
		} else {
			/*
			 * iterating all the numbers, if just one number is passed, the
			 * result of the split is an array with one element
			 */
			String[] numbersArray = numbers.split(",");
			for (String number : numbersArray) {
				try {
					Integer integerValue = Integer.valueOf(number);
					/*
					 * by the rules, if a number is multiple of 3 and 5 at the
					 * same time, is has to return FIZZ BUZZ to check if a
					 * number is multiple of another, the modulus has to be zero
					 */
					if ((integerValue % 15) == 0) {
						response += "FIZZ BUZZ ";
					} else if ((integerValue % 5) == 0) {
						response += "BUZZ ";
					} else if ((integerValue % 3) == 0) {
						response += "FIZZ ";
					} else {
						/*
						 * neither multiple of 3 nor 5, returns the number
						 * untouched
						 */
						response += number + " ";
					}
				} catch (NumberFormatException e) {
					/* ignore if not a number */
				}
			}
		}

		return Response.status(200).entity(response).build();

	}

}
