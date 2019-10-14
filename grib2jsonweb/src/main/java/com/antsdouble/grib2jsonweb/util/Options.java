package com.antsdouble.grib2jsonweb.util;

import com.lexicalscope.jewel.cli.CommandLineInterface;
import com.lexicalscope.jewel.cli.Option;
import com.lexicalscope.jewel.cli.OptionOrder;
import com.lexicalscope.jewel.cli.Unparsed;

import java.io.File;

/**
 * @author lyy
 * @description
 * @date 2019/8/12
 */
@CommandLineInterface(application="grib2json", order= OptionOrder.LONGNAME)
public interface Options {
    @Option(longName="help", shortName="h", description="display this help")
    boolean getShowHelp();

    @Option(longName="names", shortName="n", description="print names of numeric codes")
    boolean getPrintNames();

    @Option(longName="data", shortName="d", description="print GRIB record data")
    boolean getPrintData();

    @Option(longName="compact", shortName="c", description="enable compact Json formatting")
    boolean isCompactFormat();

    @Option(longName="verbose", shortName="v", description="enable logging to stdout")
    boolean getEnableLogging();

    @Option(
            longName="output",
            shortName="o",
            description="write output to the specified file (default is stdout)",
            defaultToNull=true)
    File getOutput();
    @Unparsed(name="FILE", defaultToNull=true)
    File getFile();
    // ============================
    // options to perform filtering

    @Option(
            longName={"filter.discipline", "fd"},
            description="select records with this discipline",
            defaultToNull=true)
    Integer getFilterDiscipline();

    @Option(
            longName={"filter.category", "fc"},
            description="select records with this numeric category",
            defaultToNull=true)
    Integer getFilterCategory();

    @Option(
            longName={"filter.parameter", "fp"},
            description="select records with this numeric parameter, or the string \"wind\" for both u,v components",
            defaultToNull=true)
    String getFilterParameter();

    @Option(
            longName={"filter.surface", "fs"},
            description="select records with this numeric surface type",
            defaultToNull=true)
    Integer getFilterSurface();

    @Option(
            longName={"filter.value", "fv"},
            description="select records with this numeric surface value",
            defaultToNull=true)
    Double getFilterValue();

    @Option(
            longName="recipe",
            shortName="r",
            description="a file containing a batch of filter options: fd, fc, fp, fs, fv, and o",
            defaultToNull=true)
    File getRecipe();
}
