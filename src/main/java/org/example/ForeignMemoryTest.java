package org.example;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.Arrays;

public class ForeignMemoryTest {

    public static void main(String[] args) {
        String[] names = {"fabricio", "lucas", "felicio", "jacob"};
        try(Arena offHeap = Arena.openConfined()) {
            MemorySegment pointers = offHeap.allocateArray(ValueLayout.ADDRESS, names.length);

            //copy string from on head to off head
            for (int i =0; i < names.length; i++) {
                MemorySegment cString = offHeap.allocateUtf8String(names[i]);
                pointers.setAtIndex(ValueLayout.ADDRESS, i, cString);
            }

            //copy off head to on head
            for (int i = 0; i < names.length; i++) {
                MemorySegment cString = pointers.getAtIndex(ValueLayout.ADDRESS, i);
                names[i] = cString.getUtf8String(i);
            }
        }

        System.out.println(names);
    }
}
