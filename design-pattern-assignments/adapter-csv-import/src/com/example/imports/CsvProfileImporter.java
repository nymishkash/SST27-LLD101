package com.example.imports;

import java.nio.file.Path;
import java.util.List;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader csvReader;
    private final ProfileService profileService;

    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = csvReader;
        this.profileService = profileService;
    }

    @Override
    public int importFrom(Path csvFile) {
        List<String[]> rows = csvReader.read(csvFile);
        int count = 0;
        
        for (int i = 0; i < rows.size(); i++) {
            String[] row = rows.get(i);
            
            if (i == 0 && row.length > 0 && "id".equalsIgnoreCase(row[0].trim())) {
                continue;
            }
            
            if (isValidRow(row, i + 1)) {
                try {
                    String id = row[0].trim();
                    String email = row[1].trim();
                    String displayName = row.length > 2 ? row[2].trim() : "";
                    
                    profileService.createProfile(id, email, displayName);
                    count++;
                } catch (Exception e) {
                    System.err.println("Row " + (i + 1) + ": Failed to create profile - " + e.getMessage());
                }
            }
        }
        
        return count;
    }
    
    private boolean isValidRow(String[] row, int rowNumber) {
        if (row.length < 2) {
            System.err.println("Row " + rowNumber + ": Skipped - insufficient columns (need id,email)");
            return false;
        }
        
        String id = row[0].trim();
        if (id.isEmpty()) {
            System.err.println("Row " + rowNumber + ": Skipped - missing ID");
            return false;
        }
        
        String email = row[1].trim();
        if (email.isEmpty()) {
            System.err.println("Row " + rowNumber + ": Skipped - missing email");
            return false;
        }
        
        if (!email.contains("@")) {
            System.err.println("Row " + rowNumber + ": Skipped - invalid email format: " + email);
            return false;
        }
        
        return true;
    }
}
