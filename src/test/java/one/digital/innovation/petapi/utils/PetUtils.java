package one.digital.innovation.petapi.utils;

import one.digitalinnovation.petapi.dto.request.PetDTO;
import one.digitalinnovation.petapi.entities.Pet;

import java.time.LocalDate;
import java.util.Collections;

public class PetUtils {

    private static final String PET_NAME = "Babi";
    private static final String PET_BREED = "Maltês";
    private static final String PET_WEIGH = "02,50kg";
    private static final String OWNER_NAME = "Amanda";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PET_ID = 1L;
    public static final LocalDate PET_BIRTH_DATE = LocalDate.of(2007, 03, 4);

    public static PetDTO createFakeDTO() {
        return PetDTO.builder()
                .petName(PET_NAME)
                .breed(PET_BREED)
                .petWeight(PET_WEIGH)
                .ownerName(OWNER_NAME)
                .cpf(CPF_NUMBER)
                .petBirthDate("04-03-2007")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Pet createFakeEntity() {
        return Pet.builder()
                .id(PET_ID)
                .petName(PET_NAME)
                .breed(PET_BREED)
                .petWeight(PET_WEIGH)
                .ownerName(OWNER_NAME)
                .cpf(CPF_NUMBER)
                .petBirthDate(PET_BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }




}
