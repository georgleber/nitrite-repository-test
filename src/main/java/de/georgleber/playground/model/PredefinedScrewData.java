package de.georgleber.playground.model;

import java.io.Serializable;
import java.util.UUID;

import org.dizitart.no2.IndexType;
import org.dizitart.no2.objects.Id;
import org.dizitart.no2.objects.Index;
import org.dizitart.no2.objects.Indices;

@Indices({
    @Index(value = PredefinedScrewData.PROPERTY_APP_ID, type = IndexType.Unique),
    @Index(value = PredefinedScrewData.PROPERTY_NORM_DESIGNATION, type = IndexType.Fulltext) })
public class PredefinedScrewData implements Serializable
{
    private static final long serialVersionUID = 1L;

    public static final String PROPERTY_APP_ID = "id";
    public static final String PROPERTY_NORM_DESIGNATION = "normDesignation";

    @Id
    private UUID id;
    private String normDesignation;

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID newId)
    {
        this.id = newId;
    }

    public String getNormDesignation()
    {
        return normDesignation;
    }

    public void setNormDesignation(String newNormDesignation)
    {
        this.normDesignation = newNormDesignation;

    }
}
