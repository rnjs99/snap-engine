/*
 * Copyright (C) 2011 Brockmann Consult GmbH (info@brockmann-consult.de)
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option)
 * any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, see http://www.gnu.org/licenses/
 */

package org.esa.beam.binning.operator.ui;

import com.bc.ceres.binding.ValidationException;
import com.bc.ceres.swing.binding.BindingContext;
import org.esa.beam.binning.operator.BinningOp;
import org.esa.beam.framework.datamodel.Product;

import java.beans.PropertyChangeListener;

/**
 * The model responsible for managing the binning parameters.
 *
 * @author Thomas Storm
 */
interface BinningFormModel {

    static final String PROPERTY_KEY_SOURCE_PRODUCTS = "sourceProducts";
    static final String PROPERTY_KEY_VARIABLE_CONFIGS = "variableConfigs";
    static final String PROPERTY_KEY_REGION = "region";
    static final String PROPERTY_KEY_COMPUTE_REGION = "compute";
    static final String PROPERTY_KEY_GLOBAL = "global";
    static final String PROPERTY_KEY_EXPRESSION = "expression";
    static final String PROPERTY_KEY_TIME_FILTER_METHOD = "timeFilterMethod";
    static final String PROPERTY_KEY_START_DATE_TIME = "startDateTime";
    static final String PROPERTY_KEY_PERIOD_DURATION = "periodDuration";
    static final String PROPERTY_KEY_MIN_DATA_HOUR = "minDataHour";
    static final String PROPERTY_KEY_TARGET_HEIGHT = "targetHeight";
    static final String PROPERTY_KEY_SUPERSAMPLING = "supersampling";
    static final String PROPERTY_KEY_MANUAL_WKT = "manualWktKey";
    static final String PROPERTY_KEY_SOURCE_PRODUCT_PATHS = "sourceProductPaths";

    static int DEFAULT_NUM_ROWS = 2160;

    void setProperty(String key, Object value) throws ValidationException;

    void addPropertyChangeListener(PropertyChangeListener propertyChangeListener);

    BindingContext getBindingContext();

    /**
     * @return The source products of this binning operation, never <code>null</code>.
     */
    Product[] getSourceProducts();

    /**
     * @return The variable configurations.
     */
    TargetVariableSpec[] getTargetVariableSpecs();

    /**
     * @return The selected target region.
     */
    String getRegion();

    /**
     * @return the expression good pixels in the target product need to comply with.
     */
    String getMaskExpr();

    /**
     * @return the user-chosen start date; <code>null</code> if no start date has been chosen
     */
    String getStartDateTime();

    /**
     * @return the user-chosen binning period in days
     */
    double getPeriodDuration();

    /**
     * @return the sensor-dependent constant given in hours of a day (0 to 24) at which a sensor has a minimum number of
               observations at the date line (the 180 degree meridian)
     */
    double getMinDataHour();

    /**
     * @return the user-chosen supersampling
     */
    int getSuperSampling();

    /**
     * @return the user-chosen number of rows in the planetary grid
     */
    int getNumRows();

    /**
     * @return the user-chosen time filter method
     */
    BinningOp.TimeFilterMethod getTimeFilterMethod();
}