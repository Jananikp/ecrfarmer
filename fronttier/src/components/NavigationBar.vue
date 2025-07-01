<!-- src/components/NavigationBar.vue -->
<template>
  <nav class="bg-green-800 text-white px-6 py-2 text-sm">
    <ul class="flex space-x-6">
      <li><router-link to="/" class="hover:underline">Home</router-link></li>
      <li><router-link to="/fresh" class="hover:underline">Fresh Produce</router-link></li>
      <li><router-link to="/deals" class="hover:underline">Deals</router-link></li>
      <li><router-link to="/contact" class="hover:underline">Contact</router-link></li>
    </ul>
  </nav>
</template>
