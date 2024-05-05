# Define the new data string, concatenating all the provided bits
new_data = ("1010101010101010101010101010101010101010101010101010101010101011"
            "0000000100100011010001010110011110001001101010111101111010101101"
            "1011111011101111110010101111111000001000000000000011011000110010"
            "011100110111011101100101")

# Reinitialize the CRC value
crc = 0xFFFFFFFF

# Perform CRC-32 calculation on the new data
for bit in new_data:
    top_bit_set = (crc & 0x80000000) != 0
    crc = ((crc << 1) | int(bit)) & 0xFFFFFFFF  # Left shift CRC, add current data bit
    if top_bit_set:
        crc = crc ^ crc32_polynomial  # Apply XOR with the polynomial if the top bit was set

# Finalize the CRC value by inverting all the bits
crc = crc ^ 0xFFFFFFFF

# Convert the CRC to a binary string
new_crc_binary = format(crc, '032b')
new_crc_binary
