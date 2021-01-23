package com.github.ynfeng.xunitwheel.utils;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClassScanner {
    public List<Class<?>> scan(String basePackage) {
        return loadClasses(scanClassName(basePackage));
    }

    private static List<Class<?>> loadClasses(List<String> classNames) {
        return classNames.stream().map(ClassScanner::loadClass).collect(Collectors.toList());
    }

    private static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> scanClassName(String basePackage) {
        File baseDirectory = baseDirectory(basePackage);
        List<String> result = getClassNames(basePackage, directoryFiles(baseDirectory));
        result.addAll(getChildDirsClassName(basePackage, baseDirectory));
        return result;
    }

    private static File baseDirectory(String basePackage) {
        String dir = basePackage.replace('.', File.separatorChar);
        URL url = ClassScanner.class.getClassLoader().getResource(dir);
        return new File(url.getFile());
    }

    private static Stream<File> directoryFiles(File baseDirectory) {
        return Arrays.stream(baseDirectory.listFiles()).filter(File::isFile);
    }

    private static List<String> getClassNames(String basePackage, Stream<File> stream) {
        return stream.map(File::getName)
            .map(each -> each.substring(0, each.lastIndexOf('.')))
            .map(fileName -> splicingPackage(basePackage, fileName))
            .collect(Collectors.toList());
    }

    private static String splicingPackage(String basePackage, String fileName) {
        if(basePackage == null || basePackage.isEmpty()) {
            return fileName;
        }
        return basePackage + '.' + fileName;
    }

    private static List<String> getChildDirsClassName(String pkg, File baseDir) {
        return childDirs(baseDir)
            .map(childDir -> getDirClassNames(pkg, childDir))
            .flatMap(List::stream)
            .collect(Collectors.toList());
    }

    private static List<String> getDirClassNames(String pkg, File childDir) {
        String currentPackage = splicingPackage(pkg, childDir.getName());
        List<String> classNames = getClassNames(currentPackage, directoryFiles(childDir));
        classNames.addAll(getChildDirsClassName(currentPackage, childDir));
        return classNames;
    }

    private static Stream<File> childDirs(File baseDir) {
        return Arrays.stream(baseDir.listFiles()).filter(File::isDirectory);
    }
}
