package de.georgleber.playground;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.WriteResult;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.georgleber.playground.model.PredefinedScrewData;

public class NitriteRepositoryTest
{
    private Nitrite nitrite;

    @Before
    public void createDbConnection()
    {
        this.nitrite = Nitrite.builder().compressed().filePath("test.db").openOrCreate();
    }

    @After
    public void deleteDb()
    {
        new File("test.db").delete();
    }

    @Test
    public void createAndFindTest()
    {
        ObjectRepository<PredefinedScrewData> repository = nitrite.getRepository(PredefinedScrewData.class);

        PredefinedScrewData screwData = new PredefinedScrewData();
        screwData.setId(UUID.randomUUID());
        screwData.setNormDesignation("M1");
        WriteResult result = repository.insert(screwData);
        Assert.assertEquals(1, result.getAffectedCount());

        List<PredefinedScrewData> screws = repository.find(ObjectFilters.eq("normDesignation", "M1")).toList();
        Assert.assertEquals(1, screws.size());
        Assert.assertEquals(screwData, screws.get(0));
    }
}
