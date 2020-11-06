package com.tsoft.bot.frontend.utility.services.https_petitions;

public class HttpPetitionFactory {

    public static HttpPetition getPetition(String petitionType) {

        if (petitionType == null) return null;

        if (petitionType.equalsIgnoreCase("POST")) {
            return new HttpPetitionPost();
        } else if (petitionType.equalsIgnoreCase("PUT")) {
            return new HttpPetitionPut();
        } else if (petitionType.equalsIgnoreCase("GET")) {
            return new HttpPetitionGet();
        } else {
            throw new IllegalStateException("Unexpected value: " + petitionType);
        }

    }
}
