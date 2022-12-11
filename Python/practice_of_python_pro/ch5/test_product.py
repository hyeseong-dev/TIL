import unittest

from product import Product

class ProductTestCase(unittest.TestCase):
    def test_working(self):
        pass
    
    def test_transform_name_for_sku(self):
        small_black_shoes = Product('shoes', 'S', 'black')
        expected_values = 'SHOES'
        actual_values = small_black_shoes.transform_name_for_sku()
        self.assertEqual(expected_values, actual_values)