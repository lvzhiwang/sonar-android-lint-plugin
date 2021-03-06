/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.tools.lint.detector.api;

/**
 * Severity of an issue found by lint
 * <p/>
 * <b>NOTE: This is not a public or final API; if you rely on this be prepared
 * to adjust your code for the next tools release.</b>
 */
public enum Severity {
    /**
     * Fatal: Use sparingly because a warning marked as fatal will be
     * considered critical and will abort Export APK etc in ADT
     */
    FATAL("Fatal"),

    /**
     * Errors: The issue is known to be a real error that must be addressed.
     */
    ERROR("Error"),

    /**
     * Warning: Probably a problem.
     */
    WARNING("Warning"),

    /**
     * Information only: Might not be a problem, but the check has found
     * something interesting to say about the code.
     */
    INFORMATIONAL("Information"),

    /**
     * Ignore: The user doesn't want to see this issue
     */
    IGNORE("Ignore");

    private final String mDisplay;

    private Severity(String display) {
        mDisplay = display;
    }

    /**
     * Returns a description of this severity suitable for display to the user
     *
     * @return a description of the severity
     */
    public String getDescription() {
        return mDisplay;
    }

    public static Severity fromString(String severityStr) {
        if (severityStr != null) {
            for (Severity severity : Severity.values()) {
                if (severity.getDescription().equalsIgnoreCase(severityStr)) {
                    return severity;
                }
            }
        }
        return null;
    }
}