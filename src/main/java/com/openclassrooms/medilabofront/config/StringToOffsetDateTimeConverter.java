package com.openclassrooms.medilabofront.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
public class StringToOffsetDateTimeConverter implements Converter<String, OffsetDateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public OffsetDateTime convert(String source) {
        try {
            // Conversion de la chaîne de caractères en LocalDate
            LocalDate localDate = LocalDate.parse(source, FORMATTER);
            // Convertir LocalDate à OffsetDateTime à minuit avec décalage UTC
            return localDate.atStartOfDay().atOffset(ZoneOffset.UTC);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Format de date non valide : " + source);
        }
    }
}
